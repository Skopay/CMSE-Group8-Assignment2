package com.cmsegroup8.PlantATree;

import android.support.test.rule.ActivityTestRule;
import android.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class Palm_Treetest{

    @Rule
    public ActivityTestRule<Palm_Tree> mActivityRule = new ActivityTestRule<>(Palm_Tree.class);
    private Palm_Tree pTree = null;

    @Before
    public void setUp() {
        pTree = mActivityRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view = pTree.findViewById(R.id.info);
        assertNotNull(view);
    }

    @After
    public void tearDown() {

        pTree = null;

    }
}
