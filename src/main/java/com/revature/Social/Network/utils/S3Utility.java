package com.revature.Social.Network.utils;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@Service
public class S3Utility
{
    public String picturerUrl = ".s3.amazonaws.com/";
    public String awsId = System.getenv("AWS_ID");
    public String secretKey = System.getenv("AWS_KEY");
    public String region = System.getenv("AWS_REGION");
    public String bucketName = System.getenv("AWS_BUCKET");

    public void uploadFile(MultipartFile multipartFile) throws AmazonServiceException, SdkClientException, IOException
    {
        ObjectMetadata data = new ObjectMetadata();
        data.setContentType(multipartFile.getContentType());
        data.setContentLength(multipartFile.getSize());
        BasicAWSCredentials creds = new BasicAWSCredentials(awsId,secretKey);
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region)).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
        PutObjectResult objectResult = s3client.putObject(bucketName,multipartFile.getOriginalFilename(),multipartFile.getInputStream(),data);
        System.out.println(objectResult.getContentMd5());
    }
}
