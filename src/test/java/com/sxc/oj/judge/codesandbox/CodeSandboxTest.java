package com.sxc.oj.judge.codesandbox;

import com.sxc.oj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.sxc.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.sxc.oj.judge.codesandbox.model.ExecuteCodeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CodeSandboxTest {


    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCodeByProxy(){
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code ="class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果：\"+(a+b));\n" +
                "    }\n" +
                "}";
        List<String> inputList = Arrays.asList("1 2","3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language("java")
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        System.out.println(executeCodeResponse);

    }






}