package mock;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-19 9:47 AM
 */
public class Division2 {
    public Integer divid2(Integer a, Integer b, Integer c, Division division) {
        Integer x = division.divid(a, b);
        if (x > 10) {
            return 0;
        } else {
            return x/c;
        }
    }
}
