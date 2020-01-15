package com.renruipeng.api;

import com.renruipeng.common.BaseResponse;
import com.renruipeng.enums.PermissionEnum;
import com.renruipeng.pojo.User;
import com.renruipeng.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mr--renruipeng
 * @date 2019-12-27
 **/
@RestController
@RequestMapping("/api/test")
@Slf4j
public class TestController {

    @GetMapping("/testInfo")
    public BaseResponse<String> testInfo(){

        log.info("取到的枚举名称是:{}",PermissionEnum.DELETE_STATE.name());

       String msg = MessageUtils.get(PermissionEnum.DELETE_STATE.name());

       return BaseResponse.success(msg);

    }

    @PostMapping("/printInfo")
    public BaseResponse<String> printInfo(@RequestBody User user){

        log.info("打印的字符串是:{}", user.toString());

        String msg = MessageUtils.get(PermissionEnum.DELETE_STATE.name());

        return BaseResponse.success(msg);

    }

}
