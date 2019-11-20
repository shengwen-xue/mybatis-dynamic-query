package com.github.wz2cool.dynamic.mybatis.mapper;

import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.helper.CommonsHelper;
import com.github.wz2cool.dynamic.lambda.GetBigDecimalPropertyFunction;
import com.github.wz2cool.dynamic.lambda.GetBytePropertyFunction;
import com.github.wz2cool.dynamic.mybatis.MathUtils;
import com.github.wz2cool.dynamic.mybatis.QueryHelper;
import com.github.wz2cool.dynamic.mybatis.mapper.constant.MapperConstants;
import com.github.wz2cool.dynamic.mybatis.mapper.provider.DynamicQueryProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Frank
 */
@RegisterMapper
@SuppressWarnings("squid:S1214")
public interface SelectMaxByDynamicQueryMapper<T> {

    QueryHelper QUERY_HELPER = new QueryHelper();

    /**
     * Select max value of column by dynamic query.
     *
     * @param column       the column need get max value
     * @param dynamicQuery dynamic query
     * @return max value of column.
     */
    @SelectProvider(type = DynamicQueryProvider.class, method = "dynamicSQL")
    Object selectMaxByDynamicQuery(
            @Param(MapperConstants.COLUMN) String column, @Param(MapperConstants.DYNAMIC_QUERY) DynamicQuery<T> dynamicQuery);

    /**
     * Select max value of property by dynamic query.
     *
     * @param getPropertyFunction the property need get max value
     * @param dynamicQuery        dynamic query.
     * @return max value of property.
     */
    default Optional<BigDecimal> selectMaxByDynamicQuery(
            GetBigDecimalPropertyFunction<T> getPropertyFunction, DynamicQuery<T> dynamicQuery) {
        String propertyName = CommonsHelper.getPropertyName(getPropertyFunction);
        Class entityClass = dynamicQuery.getEntityClass();
        String queryColumn = QUERY_HELPER.getQueryColumnByProperty(entityClass, propertyName);
        Object result = selectMaxByDynamicQuery(queryColumn, dynamicQuery);
        if (result == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(MathUtils.getBigDecimal(result));
        }
    }

    /**
     * Select max value of property by dynamic query.
     *
     * @param getPropertyFunction the property need get max value
     * @param dynamicQuery        dynamic query.
     * @return max value of property.
     */
    default Optional<Byte> selectMaxByDynamicQuery(
            GetBytePropertyFunction<T> getPropertyFunction, DynamicQuery<T> dynamicQuery) {
        String propertyName = CommonsHelper.getPropertyName(getPropertyFunction);
        Class entityClass = dynamicQuery.getEntityClass();
        String queryColumn = QUERY_HELPER.getQueryColumnByProperty(entityClass, propertyName);
        Object result = selectMaxByDynamicQuery(queryColumn, dynamicQuery);
        if (result == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(MathUtils.getByte(result));
        }
    }
}
