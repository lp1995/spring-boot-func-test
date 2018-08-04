package com.liupeng.faceSigned.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qcloud.image.ImageClient;
import com.qcloud.image.request.FaceCompareRequest;

@Controller
public class faceController {
	
	private String appId="1252077372";
	private String secretId="AKIDeqZcDy6FAVLZBd6EQoGEkAhiHxWQ8URi";
	private String secretKey="NPhr9W7MDnMivIBff45bxhLaqsR5Cv33";
	private ImageClient imageClient = new ImageClient(appId, secretId, secretKey);
	private String bucketName= "face-defected";
	
	@RequestMapping(value = {"/","/index"})
	@ResponseBody
    public String index(){
        return "index";
    }
	
	@RequestMapping(value = {"/test"})
    public String test(){
		faceFaceCompare();
        return "test.html";
    }
	
	/**
     * 人脸对比操作
     */
    private void faceFaceCompare() {
        //2. 图片内容方式
        System.out.println("====================================================");
        File imageA = new File("D:\\123456.jpg");
        File imageB = new File("D:\\123456.jpg");
        FaceCompareRequest faceCompareReq = new FaceCompareRequest(bucketName, imageA, imageB);
        String ret = imageClient.faceCompare(faceCompareReq);
        System.out.println("face compare ret:" + ret);
    }

}
