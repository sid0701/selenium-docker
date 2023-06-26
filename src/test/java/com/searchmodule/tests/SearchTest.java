package com.searchmodule.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.both.testcomponents.BaseTest;
import com.searchmodule.pages.SearchPage;

public class SearchTest extends BaseTest {

	@Test
	@Parameters({ "keyword" })
	public void search(String keyword) {
		SearchPage sp = new SearchPage(driver);
		sp.goTo();
		sp.doSearch(keyword);
		sp.doClick();
		sp.goToVideos();
		int no = sp.noOfVideos();
		Assert.assertTrue(no > 0);
	}

}
