package currency.converter.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static currency.converter.utils.ConverterConstants.EUROS_TO_POUNDS;
import static currency.converter.utils.ConverterConstants.EUROS_TO_USD;
import static currency.converter.utils.ConverterConstants.EUROS_TO_YEN;
import static currency.converter.utils.ConverterConstants.EUROS_TO_YUAN;
import static currency.converter.utils.ConverterConstants.POUNDS_TO_EUROS;
import static currency.converter.utils.ConverterConstants.POUNDS_TO_USD;
import static currency.converter.utils.ConverterConstants.POUNDS_TO_YEN;
import static currency.converter.utils.ConverterConstants.POUNDS_TO_YUAN;
import static currency.converter.utils.ConverterConstants.USD_TO_EUROS;
import static currency.converter.utils.ConverterConstants.USD_TO_POUNDS;
import static currency.converter.utils.ConverterConstants.USD_TO_YEN;
import static currency.converter.utils.ConverterConstants.USD_TO_YUAN;
import static currency.converter.utils.ConverterConstants.YEN_TO_EUROS;
import static currency.converter.utils.ConverterConstants.YEN_TO_POUNDS;
import static currency.converter.utils.ConverterConstants.YEN_TO_USD;
import static currency.converter.utils.ConverterConstants.YEN_TO_YUAN;
import static currency.converter.utils.ConverterConstants.YUAN_TO_EUROS;
import static currency.converter.utils.ConverterConstants.YUAN_TO_POUNDS;
import static currency.converter.utils.ConverterConstants.YUAN_TO_USD;
import static currency.converter.utils.ConverterConstants.YUAN_TO_YEN;

@UtilityClass
public class TestUtils {

    public Map<String, BigDecimal> returnTestResponse_pounds(){
        Map<String, BigDecimal> testDataMap = new HashMap<>();
        testDataMap.put(POUNDS_TO_EUROS, new BigDecimal("115.009540000"));
        testDataMap.put(POUNDS_TO_USD, new BigDecimal("139.893170000"));
        testDataMap.put(POUNDS_TO_YEN, new BigDecimal("15187.590000"));
        testDataMap.put(POUNDS_TO_YUAN, new BigDecimal("899.730140000"));
        return testDataMap;
    }

    public Map<String, BigDecimal> returnTestResponse_usd(){
        Map<String, BigDecimal> testDataMap = new HashMap<>();
        testDataMap.put(USD_TO_POUNDS, new BigDecimal("071.483119000"));
        testDataMap.put(USD_TO_EUROS, new BigDecimal("082.212403000"));
        testDataMap.put(USD_TO_YEN, new BigDecimal("10856.563000000"));
        testDataMap.put(USD_TO_YUAN, new BigDecimal("643.155160000"));
        return testDataMap;
    }

    public Map<String, BigDecimal> returnTestResponse_euros(){
        Map<String, BigDecimal> testDataMap = new HashMap<>();
        testDataMap.put(EUROS_TO_POUNDS, new BigDecimal("086.949312000"));
        testDataMap.put(EUROS_TO_USD, new BigDecimal("121.636150000"));
        testDataMap.put(EUROS_TO_YEN, new BigDecimal("13205.505000000"));
        testDataMap.put(EUROS_TO_YUAN, new BigDecimal("782.309160000"));
        return testDataMap;
    }

    public Map<String, BigDecimal> returnTestResponse_yen(){
        Map<String, BigDecimal> testDataMap = new HashMap<>();
        testDataMap.put(YEN_TO_POUNDS, new BigDecimal("000.658432330"));
        testDataMap.put(YEN_TO_EUROS, new BigDecimal("000.757259960"));
        testDataMap.put(YEN_TO_USD, new BigDecimal("000.921101850"));
        testDataMap.put(YEN_TO_YUAN, new BigDecimal("8005.924114100"));
        return testDataMap;
    }

    public Map<String, BigDecimal> returnTestResponse_yuan(){
        Map<String, BigDecimal> testDataMap = new HashMap<>();
        testDataMap.put(YUAN_TO_POUNDS, new BigDecimal("011.114444000"));
        testDataMap.put(YUAN_TO_EUROS, new BigDecimal("012.782670000"));
        testDataMap.put(YUAN_TO_USD, new BigDecimal("015.548348000"));
        testDataMap.put(YUAN_TO_YEN, new BigDecimal("1688.016100000"));
        return testDataMap;
    }
}
