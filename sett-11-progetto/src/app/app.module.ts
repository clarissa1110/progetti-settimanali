import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { FavouritesComponent } from './components/favourites/favourites.component';
import { MoviesComponent } from './components/movies/movies.component';
import { MoviesDetailsComponent } from './components/movies-details/movies-details.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { UsersListComponent } from './components/users-list/users-list.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';

const routes: Route[] = [
  {
    path:'', 
    component: HomeComponent
  },
  {
    path:'movies',
    component:MoviesComponent
  },
  {
    path: 'movies-details',
    component: MoviesDetailsComponent
  },
  {
    path: 'users',
    component: UsersListComponent
  },
  {
    path: 'profile',
    component: UserProfileComponent
  },
  {
    path: 'favourites',
    component: FavouritesComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FavouritesComponent,
    MoviesComponent,
    MoviesDetailsComponent,
    UserProfileComponent,
    UsersListComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
