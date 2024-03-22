import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { RandomHomeComponent } from './home/random-home/random-home.component';
import { Marchio1Component } from './marchio1/marchio1.component';
import { Marchio2Component } from './marchio2/marchio2.component';
import { Marchio3Component } from './marchio3/marchio3.component';
import { HomeBrandComponent } from './home/home-brand/home-brand.component';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent
  }, 
  {
    path: 'Audi',
    component: Marchio1Component
  },
  {
    path: 'Fiat',
    component: Marchio2Component
  },
  {
    path: 'Ford',
    component: Marchio3Component
  }
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    RandomHomeComponent,
    Marchio1Component,
    Marchio2Component,
    Marchio3Component,
    HomeBrandComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
