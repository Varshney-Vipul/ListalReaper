public class GlobalFlags{
    public static boolean shouldGenerateMoreLinks = true;
    public static double latestImageString = 0.0;
    public static double nextLatestImageString = 0.0;
    public static int picCount = 0;
    public static int localPicCount = 0;
    public static boolean isPicCountAchieved(){
        return localPicCount < picCount;
    }
}