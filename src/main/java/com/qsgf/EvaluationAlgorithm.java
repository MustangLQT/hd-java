package com.qsgf;

public class EvaluationAlgorithm {

    // 算法1: TOPSIS评价法

    // 输入参数
    // 备注:
    //   score中各指标的方案数据，需个数相同，且依次对应。
    public class A1In {
        public double[][] score;  // 决策矩阵。各指标的各方案的分数。score[指标个数][方案个数]
    }

    // 输出参数
    // 备注:
    //   result中的数据与score中的各方案，依次对应。
    public class A1Out {
        public double[]   result; // 各方案的综合评价值。result[方案个数]
    }

    // 名称:
    //   TOPSIS评价法
    // 参数:
    //   A1In  in:  输入参数
    //   A1Out out: 输出参数
    // 返回值:
    //   int:       0 - 成功、1 - 失败
    public native int topsis(A1In in, A1Out out);


    // 算法2: 物元分析法

    // 输入参数
    // 备注:
    //   classic、evaluation、weight三者中的各指标，需依次对应。
    //   classic中各指标的各等级上下限，依次为：等级1下限、等级1上限、等级2下限、等级2上限、... 、等级n下限、等级n上限。
    public class A2In {
        public double[][] classic;     // 经典域物元矩阵。各指标的各等级上下限。classic[指标个数][各等级的下限、上限]
        public double[]   evaluation;  // 待评价物元。各指标的值。evaluation[指标个数]
        public double[]   weight;      // 指标权重。各指标的权重。weight[指标个数]
    }

    // 输出参数
    // 备注:
    //   correlation中的数据与classic中的各等级，依次对应。
    public class A2Out {
        public double[]   correlation; // 与各等级的关联度。correlation[等级个数]
    }

    // 名称:
    //   物元分析法
    // 参数:
    //   A2In  in:  输入参数
    //   A2Out out: 输出参数
    // 返回值:
    //   int:       0 - 成功、1 - 失败
    public native int matterElementAnalysis(A2In in, A2Out out);


    // 算法3: 多级可拓评价法

    // 输入参数
    // 备注:
    //   classic、evaluation、weight三者中的各二级指标，需依次对应。
    //   weightL1、mappingL1二者中的各一级指标，需依次对应。
    //   classic中各二级指标的各等级上下限，依次为：等级1下限、等级1上限、等级2下限、等级2上限、... 、等级n下限、等级n上限。
    //   weightL1中各一级指标，需依次对应classic中的二级指标组。
    //   mappingL1中各一级指标对应二级指标个数的总和，需与classic中二级指标的个数相等。
    public class A3In {
        public double[][] classic;     // 经典域物元矩阵。各二级指标的各等级上下限。classic[二级指标个数][各等级的下限、上限]
        public double[]   evaluation;  // 待评价物元。各二级指标的值。evaluation[二级指标个数]
        public double[]   weight;      // 二级指标权重。各二级指标的权重。weight[二级指标个数]
        public double[]   weightL1;    // 一级指标权重。各一级指标的权重。weightL1[一级指标个数]
        public int[]      mappingL1;   // 一级指标对应关系。各一级指标对应二级指标的个数。mappingL1[一级指标个数]
    }

    // 输出参数
    public class A3Out {
        public double     eigenvalue;  // 等级变量特征值。
    }

    // 名称:
    //   多级可拓评价法
    // 参数:
    //   A3In  in:  输入参数
    //   A3Out out: 输出参数
    // 返回值:
    //   int:       0 - 成功、1 - 失败
    public native int multilevelExtensionAssessment(A3In in, A3Out out);

    //算法测试
    public native String AlgoTest(String json);

}
