package com.revature.Social.Network.utils;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

public class S3Utility
{
    public String picturerUrl = ".s3.amazonaws.com/";
    private String awsId = System.getenv("AWS_ID");
    private String secretKey = System.getenv("AWS_KEY");
    private String region = "us-east-1";
    public String bucketName = System.getenv("AWS_BUCKET");

    public void uploadFile(File file)
    {
//        throws S3Exception, AwsServiceException, SdkClientException, IOException {
//        S3Client client = S3Client.builder().build();
//
//        PutObjectRequest request = PutObjectRequest
//                .bucket(bucketName)
//                .key(file.getName())
//                .build();
//
//        client.putObject(request,
//                RequestBody.fromInputStream(inputStream, inputStream.available()));
//    }
    }
}
