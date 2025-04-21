package com.coding404.myweb.controller;

import com.coding404.myweb.command.ProductUploadVO;
import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.service.ProductMapper;
import com.coding404.myweb.product.service.ProductService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService; //생성한 ProductService라는 이름을 가진 파일


    //화면처리
//    @GetMapping("/productList")
//    public String productList(Model model) {
//        //select
//        String prodWriter = "admin";
//        ArrayList<ProductVO> list = productService.getList(prodWriter);
//        //이제 화면으로 가지고 나가야함 그래서  productList 매개변수에 Model을 써준다
//        model.addAttribute("list", list);
//
//        //진짜 도저히 데이터가 넘어오는 지 모르겠다? 그럼 이걸 적는거야
//        log.info(list.toString());
//
//        return "product/productList";
//    }

    @GetMapping("/productList")
    public String productList(Model model,
                              Criteria cri) {

        String prodWriter = "admin";
        ArrayList<ProductVO> list = productService.getList(prodWriter, cri);
        int total = productService.getTotal(prodWriter,cri); //토탈
        PageVO pageVO = new PageVO(cri, total);//페이지네이션

        model.addAttribute("list", list);
        model.addAttribute("pageVO", pageVO);

        return "product/productList";
    }

    @GetMapping("/productReg")
    public String productReg() {
        return "product/productReg";
    }

    @GetMapping("/productDetail")
    public String productDetail(@RequestParam("prodId") String prodId,
                                Model model) { //필수인 값을 안넣어주면 동작을 하지 않음
        //prodId를 받아서 해당 상품을 조회
        ProductVO vo = productService.getDetail(prodId); //product타입으로 반환
        List<ProductUploadVO> voImg = productService.getDetailImg(prodId);
        //이제 화면으로 가져가야 하니까 model 선언
        model.addAttribute("vo", vo);
        model.addAttribute("voImg", voImg);

        return "product/productDetail";
    }
    //등록기능
    @PostMapping("/registForm") //등록하고 나서 데이터를 가지고 다른 화면으로 가는 게 아니라 그냥 list로 이동함
    public String registForm(ProductVO vo,
                             RedirectAttributes ra,
                             @RequestParam("file") List<MultipartFile> list) {  //productVO로 받음 //일회성 메시지 RedirectAttributes

        //1. 리스트안에 multipartfile의 값이 비었으면 제거
        list = list.stream()
                   .filter(f -> f.isEmpty() == false)
                   .collect(Collectors.toList());

        //2. 이미지 타입인지 검사
        for(MultipartFile file :list){
            if (file.getContentType().contains("image") ==false){ //이미지가 아니면
                ra.addFlashAttribute("msg", "이미지만 업로드가 가능합니다.");
                return "redirect:/product/productList";
            }
        }

//        log.info(list.toString());

        int result = productService.productRegist(vo,list); //vo객체와, 파일리스트
        //1이면 성공, 0이면 실패
        if (result == 1) {
            ra.addFlashAttribute("msg", "정상 등록되었습니다");
        } else {
            ra.addFlashAttribute("msg", "시스템 문제로 인해 등록에 실패했습니다\n1577-1000으로 문의주세요.");
        }
        return "redirect:/product/productList";
    }

    //update Form
    @PostMapping("/updateForm")
    public String updateForm(ProductVO vo){
//        log.info(vo.toString());

        productService.productUpdate(vo);

        //상세화면이 prodId를 필요로 하기 때문에 매개변수로 싣고 보내줘야함.
        return "redirect:/product/productDetail?prodId=" + vo.getProdId(); //수정하고 content 화면으로
    }

    /*
    삭제기능
    1. 화면에서는 deleteForm으로 삭제요청이 넘어옵니다. (데이터는 다 넘어옴~)
    2. int productDelete메서드를 이용해서 삭제를 진행하면 됩니다.
    3. 삭제 후에는 목록으로 넘어가면 됩니다.
        삭제 성공 시 mag를 보내주세요.
        삭제 실패 시 실패msg를 보내주면 됩니다.
     */
    @PostMapping("/deleteForm")
    public String deleteForm(@RequestParam("prodId") String id,
                             RedirectAttributes ra) {

        int result = productService.productDelete(id);
        if(result == 1) {
            ra.addFlashAttribute("msg", "삭제 되었습니다");
        } else {
            ra.addFlashAttribute("msg", "삭제에 실패했습니다");
        }


        return "redirect:/product/productList";
    }
}


