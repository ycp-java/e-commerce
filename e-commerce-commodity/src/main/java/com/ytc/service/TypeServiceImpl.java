/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TypeServiceImpl
 * Author:   ycp
 * Date:     2020/10/14 9:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ytc.mapper.TypeMapper;
import com.ytc.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ycp
 * @create 2020/10/14
 * @since 1.0.0
 */
@Service
@Component
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> selecttype() {
        return typeMapper.selecttype();
    }

    @Override
    public List<Type> queryTypelist() {
        return typeMapper.queryTypelist();
    }
}