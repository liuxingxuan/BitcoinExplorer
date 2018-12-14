package io.lxx.bitcoinexplorerwebapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.HashMap;

@RestController
@RequestMapping("/blockchain")
public class BlockChainController {

    /**
     * 查看区块的基本信息JSON  RPC
     */
    @GetMapping("/getBasicInfo")
    public void getBasicInfo() throws Throwable {
        JsonRpcHttpClient client = new JsonRpcHttpClient(
                new URL("http://localhost:18332/"));
        //用户登录信息
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization","Basic bHh4OjEyMzQ1Ng==");
        client.setHeaders(headers);
        //rpc调用
        JSONObject getblockchaininfo = client.invoke("getblockchaininfo", new Object[]{ }, JSONObject.class);
//        BlockChainBasicInfo getblockchaininfo = client.invoke("getblockchaininfo", new Object[]{ }, BlockChainBasicInfo.class);
    }
}
