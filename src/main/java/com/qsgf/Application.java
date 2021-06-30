package com.qsgf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        try {
//            NativeLoader.loader( "jni" );
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("加载失败");
//        }
//        // algorithm1Sample();
//        algorithm1Sample1();
    }
    // 算法1: TOPSIS评价法
    public static void algorithm1Sample() {
        EvaluationAlgorithm ea = new EvaluationAlgorithm();
        EvaluationAlgorithm.A1In in = ea.new A1In();
        EvaluationAlgorithm.A1Out out = ea.new A1Out();

        // 决策矩阵。各指标的各方案的分数。score[指标个数][方案个数]
        in.score = new double[][] {
                // 义乌市, 东阳市, 永康市, 兰溪市, 婺城区, 武义县, 金东区, 浦江县, 磐安县
                // 指标1
                {84.72, 76.44, 74.48, 73.60, 73.23, 71.86, 70.32, 69.50, 64.79},
                // 指标2
                {84.72, 76.44, 74.48, 73.60, 73.23, 71.86, 70.32, 69.50, 64.79},
                // 指标3
                {83.72, 75.44, 73.48, 72.60, 72.23, 70.86, 69.32, 68.50, 63.79},
                // 指标4
                {82.72, 74.44, 72.48, 71.60, 71.23, 69.86, 68.32, 67.50, 62.79},
                // 指标5
                {81.72, 73.44, 71.48, 70.60, 70.23, 68.86, 67.32, 66.50, 61.79},
                // 指标6
                {80.72, 72.44, 70.48, 69.60, 69.23, 67.86, 66.32, 65.50, 60.79},
                // 指标7
                {79.72, 71.44, 69.48, 68.60, 68.23, 66.86, 65.32, 64.50, 59.79},
                // 指标8
                {78.72, 70.44, 68.48, 67.60, 67.23, 65.86, 64.32, 63.50, 58.79},
                // 指标9
                {77.72, 69.44, 67.48, 66.60, 66.23, 64.86, 63.32, 62.50, 57.79},
                // 指标10
                {76.72, 68.44, 66.48, 65.60, 65.23, 63.86, 62.32, 61.50, 56.79},};

        // 各方案的综合评价值。result[方案个数]
        out.result = new double[in.score[0].length];

        // TOPSIS评价法
        int ret = ea.topsis(in, out);

        // 打印算法结果
        System.out.println("算法1-TOPSIS评价法");
        if (ret == 0) {
            System.out.println("各方案的综合评价值：");
            for (double result : out.result) {
                System.out.println(result);
            }
        } else {
            System.out.println("计算失败");
        }
        System.out.println();
    }

    // 算法1: TOPSIS评价法
    public static void algorithm1Sample1() {
        InvestCapacity ic = new InvestCapacity();
        JSONObject json = new JSONObject();
            json.put("tzBase",5000);
            json.put("elecSocial",0.95);
            json.put("elecSell",0.95);
            json.put("newEnergy",0.95);
            json.put("avgPB",0.95);
            json.put("maxLoadInc",0.95);
            json.put("price",0.95);
            json.put("tzys",0.95);
            json.put("lineLoss",0.95);
            json.put("zjl",0.95);
            json.put("fzl",0.95);
            json.put("lr",0.95);
        String param = JSON.toJSONString(json);
        String result = ic.AlgoTest(param);
        System.out.println(result);
    }
}
