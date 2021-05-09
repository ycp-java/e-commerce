/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AdressServiceImpl
 * Author:   ycp
 * Date:     2020/10/15 15:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ytc.mapper.AdressMapper;
import com.ytc.model.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ycp
 * @create 2020/10/15
 * @since 1.0.0
 */
@Service
@Component
public class AdressServiceImpl implements AdressService {
@Autowired
   private AdressMapper adressMapper;

   @Override
   public List<Adress> selectadr(Integer userid) {
      return adressMapper.selectadr(userid);
   }
}