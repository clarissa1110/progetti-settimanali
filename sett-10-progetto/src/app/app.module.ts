import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { CompletedTasksComponent } from './components/completed-tasks/completed-tasks.component';
import { TasksLeftComponent } from './components/tasks-left/tasks-left.component';
import { AllTasksComponent } from './components/all-tasks/all-tasks.component';
import { UsersComponent } from './components/users/users.component';
import { User } from './models/user.interface';

const routes: Route[] = [
  {
    path:'',
    component: AllTasksComponent
  },
  {
    path:'completed-tasks',
    component: CompletedTasksComponent
  },
  {
    path: 'tasks-left',
    component: TasksLeftComponent
  },
  {
    path: 'users',
    component: UsersComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    CompletedTasksComponent,
    TasksLeftComponent,
    AllTasksComponent,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
