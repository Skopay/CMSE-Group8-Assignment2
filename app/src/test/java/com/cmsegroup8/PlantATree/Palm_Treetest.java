package com.cmsegroup8.PlantATree;

import android.support.test.rule.ActivityTestRule;
import android.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class Palm_Treetest{

    @Rule
    public ActivityTestRule<Palm_Tree> mActivityRule = new ActivityTestRule<Palm_Tree>(Palm_Tree.class);
    private Palm_Tree Ptree = null;

    @Before
    public void setUp() throws Exception{
        Ptree = mActivityRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view = Ptree.findViewById(R.id.info);
        asserNotNull(view);
    }

    @After
    public void tearDown() throws Exception {

        Ptree = null;

    }
}
