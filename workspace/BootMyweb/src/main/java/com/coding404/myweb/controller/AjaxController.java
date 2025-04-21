package com.coding404.myweb.controller;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

@RestController
public class AjaxController {

    @Value("${com.coding404.myweb.upload.path}")
    private String uploadPath;


    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    //요청파라미터 x, List<카테고리> 반환
    @GetMapping("/getCategory")
    public ResponseEntity<List<CategoryVO>> getCategory() {
        return new ResponseEntity<>(productService.getCategory(),
                HttpStatus.OK );
    }

    @GetMapping("/getCategorySub/{groupId}/{categoryLv}/{categoryDetailLv}")
    public ResponseEntity<List<CategoryVO>> getCategorySub(@PathVariable("groupId") String groupId,
                                                           @PathVariable("categoryLv") Integer categoryLv,
                                                           @PathVariable("categoryDetailLv") Integer categoryDetailLv) {
        CategoryVO vo = CategoryVO.builder()
                .groupId(groupId)
                .categoryLv(categoryLv)
                .categoryDetailLv(categoryDetailLv)
                .build();
        return new ResponseEntity<>(productService.getCategorySub(vo),
                HttpStatus.OK);
    }

    //이미지 응답기능
    //클라이언트에서 요청은 display?파일패스=값&uuid=값&파일명=값
    @GetMapping("/display")
    public ResponseEntity<byte[]> display(@RequestParam("filepath") String filepath,
                                          @RequestParam("uuid") String uuid,
                                          @RequestParam("filename") String filename) {

        String path = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
        byte[] fileData = null; //데이터정보
        HttpHeaders header = new HttpHeaders(); //헤더정보

        try {
            File file = new File(path);
            fileData = FileCopyUtils.copyToByteArray(file); //파일을 읽어서 바이트로 반환
            header.add("Content-type", Files.probeContentType( file.toPath()  ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(fileData, header, HttpStatus.OK);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("filepath") String filepath,
                                           @RequestParam("uuid") String uuid,
                                           @RequestParam("filename") String filename) {

        String path = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
        byte[] fileData = null; //데이터정보
        HttpHeaders header = new HttpHeaders(); //헤더정보

        try {
            File file = new File(path);
            fileData = FileCopyUtils.copyToByteArray(file); //파일을 읽어서 바이트로 반환
            header.add("Content-Disposition", "attachment; filename=" + filename );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(fileData, header, HttpStatus.OK);
    }



}
