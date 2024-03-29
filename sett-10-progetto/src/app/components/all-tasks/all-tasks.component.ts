import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task.interface';
import { User } from 'src/app/models/user.interface';
import { TasksService } from 'src/app/services/tasks.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-all-tasks',
  templateUrl: './all-tasks.component.html',
  styleUrls: ['./all-tasks.component.scss'],
})
export class AllTasksComponent {
  tasks!: Task[];
  users!: User[];
  taskUser: Task[] = [];
  user!: User;
  //userName!: string;

  constructor(private taskSrv: TasksService, private userSrv: UsersService) {
    this.tasks = this.taskSrv.tasks;

    this.users = this.userSrv.users;

    for (let i = 0; i < this.users.length; i++) {
      for (let j = 0; j < this.tasks.length; j++) {
        if (this.tasks[j].userId === this.users[i].id) {
          this.user=this.users[i]
        }
      }
    }
  }
}
