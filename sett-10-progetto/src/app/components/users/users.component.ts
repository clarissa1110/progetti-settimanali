import { Component } from '@angular/core';
import { Task } from 'src/app/models/task.interface';
import { User } from 'src/app/models/user.interface';
import { TasksService } from 'src/app/services/tasks.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent {
  users!: User[];
  tasks!: Task[];
  taskUser!: Task[]
 

  constructor(private taskSrv: TasksService, private userSrv: UsersService) {
    this.tasks = this.taskSrv.tasks;
    console.log(this.tasks);
    

    this.users = this.userSrv.users;
    console.log(this.users);

    this.users.forEach((user) => {this.taskUser = this.tasks.filter(task => task.userId === user.id) 
      console.log(this.taskUser);
    
})


  }

}
