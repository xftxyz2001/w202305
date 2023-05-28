public class Test2469 {
    // 开氏度 = 摄氏度 + 273.15
    // 华氏度 = 摄氏度 * 1.80 + 32.00
    public double[] convertTemperature(double celsius) {
        return new double[] { celsius + 273.15, celsius * 1.80 + 32.00 };
    }
}
