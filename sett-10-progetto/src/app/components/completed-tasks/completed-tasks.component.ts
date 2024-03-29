import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task.interface';
import { TasksService } from 'src/app/services/tasks.service';

@Component({
  selector: 'app-completed-tasks',
  templateUrl: './completed-tasks.component.html',
  styleUrls: ['./completed-tasks.component.scss']
})
export class CompletedTasksComponent implements OnInit {
  tasks!: Task[];

  constructor(private taskSrv: TasksService) {}

async ngOnInit(): Promise<void> {
 const tasks = this.taskSrv.getTasks();
 this.tasks = tasks.filter(task => task.completed === true)
}

}
