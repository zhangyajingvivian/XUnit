package unit;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-18 11:53 AM
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowGroup.class)
@Categories.ExcludeCategory(FastGroup.class)
@Suite.SuiteClasses({
        TestGroups.class
})
public class TestGroupsRunSuite {
}
