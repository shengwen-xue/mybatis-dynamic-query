package com.github.wz2cool.dynamic.mybatis.mapper;

import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.mybatis.mapper.constant.MapperConstants;
import com.github.wz2cool.dynamic.mybatis.mapper.provider.DynamicQueryProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

/**
 * @author Frank
 */
@RegisterMapper
public interface SelectMinByDynamicQueryMapper<T> {

    /**
     * Select min value of property by dynamic query.
     *
     * @param property     the property need get min value.
     * @param dynamicQuery dynamic query
     * @return min value of property.
     */
    @SelectProvider(type = DynamicQueryProvider.class, method = "dynamicSQL")
    Object selectMinByDynamicQuery(
            @Param(MapperConstants.COLUMN) String property, @Param(MapperConstants.DYNAMIC_QUERY) DynamicQuery<T> dynamicQuery);
}
