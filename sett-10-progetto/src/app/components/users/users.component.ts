import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task.interface';
import { User } from 'src/app/models/user.interface';
import { TasksService } from 'src/app/services/tasks.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
})
export class UsersComponent implements OnInit {
  users: User[] = [];
  tasks!: Task[];
  taskUser!: Task[];

  constructor(private taskSrv: TasksService, private userSrv: UsersService) {}

  ngOnInit(): void {
    this.tasks = this.taskSrv.tasks;

    this.users = this.userSrv.users;

    this.users.forEach((user) => {
      this.taskUser = this.tasks.filter((task) => task.userId === user.id);
      console.log(this.taskUser);
    });
  }
}
