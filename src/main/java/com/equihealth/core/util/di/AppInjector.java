package com.equihealth.core.util.di;

import com.equihealth.core.service.PriceService;
import com.equihealth.core.service.PriceServiceImpl;
import com.google.inject.AbstractModule;


public class AppInjector extends AbstractModule {

  @Override
  protected void configure() {

    bind(PriceService.class).to(PriceServiceImpl.class);

  }

}
