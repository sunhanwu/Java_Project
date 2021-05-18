package ucas.java.sunhanwu.utils;

public class IP2Area {

    public static String ip2Area(String ip)
    {
        String result = null;
        switch (ip)
        {
            case "202.14.67.4":
                result = "印度";
                break;
            case "8.8.4.4":
                result = "加州";
                break;
            case "223.6.6.6":
                result = "杭州";
                break;
            case "8.8.8.8":
                result = "加州";
                break;
            case "77.88.8.8":
                result = "俄罗斯";
                break;
            case "84.200.69.80":
                result = "德国";
                break;
            case "219.141.140.10":
                result = "北京";
                break;
            case "168.95.1.1":
                result = "台湾";
                break;
            case "45.248.197.5":
                result = "澳大利亚";
                break;
            case "79.141.82.250":
                result = "瑞士";
                break;
            case "210.22.70.3":
                result = "上海";
                break;
            case "80.80.80.80":
                result = "荷兰";
                break;
            case "221.11.1.67":
                result = "陕西";
                break;
            case "61.132.163.68":
                result = "安徽";
                break;
            case "91.239.100.100":
                result = "丹麦";
                break;
            case "165.87.13.129":
                result = "德州";
                break;
            default:
                result = "其他";
                break;
        }
        return result;
    }

}
