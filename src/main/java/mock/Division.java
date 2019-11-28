package mock;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-19 9:47 AM
 */
public class Division {
    public Integer divid(Integer a, Integer b) {
        if (0 == b) {
            return null;
        } else if (a < b) {
            return 0;
        } else if (a > 100) {
            return null;
        } else {
            return a/b;
        }
    }
}
