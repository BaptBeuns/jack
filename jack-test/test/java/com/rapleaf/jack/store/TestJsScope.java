package com.rapleaf.jack.store;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestJsScope {

  @Test
  public void testRootScope() {
    JsScope rootScope = JsScope.root();
    assertTrue(rootScope.isRootScope());
    assertNull(rootScope.getParentScopeId());
    assertNull(rootScope.getScopeId());
    assertEquals(JsConstants.ROOT_SCOPE_NAME, rootScope.getScopeName());
  }

}
