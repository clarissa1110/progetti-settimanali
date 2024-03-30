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
export class AllTasksComponent implements OnInit {
  tasks: Task[] = [];
  users: User[] = [];
  user: User = {
    id: 0,
    firstName: '',
    lastName: '',
    email: '',
    image: '',
    title: '',
  };
  //userName!: string;

  constructor(private taskSrv: TasksService, private userSrv: UsersService) {
    // for (let i = 0; i < this.users.length; i++) {
    //   for (let j = 0; j < this.tasks.length; j++) {
    //     if (this.tasks[j].userId === this.users[i].id) {
    //       this.user = this.users[i];
    //     }
    //     console.log(this.tasks[j]);
    //
    //   }
    // }
  }

  async ngOnInit(): Promise<void> {
    this.tasks = this.taskSrv.tasks;

    this.users = this.userSrv.users;

    for (let i = 0; i < this.tasks.length; i++) {
      for (let j = 0; j < this.users.length; j++)
        if (this.tasks[i].userId === this.users[j].id) {
          console.log(this.user);
          this.user = this.users[j];
        }
    }
  }

  notCompletedTasks(id: number, index: number) {
    this.taskSrv.updateTask(id, { completed: true });
    this.tasks.splice(index, 1);
  }

  completedTasks(id: number, index: number) {
    this.taskSrv.updateTask(id, { completed: false });
    this.tasks.splice(index, 1);
  }
}
