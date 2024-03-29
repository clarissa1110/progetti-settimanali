import { Component, OnInit} from '@angular/core';
import { Task } from 'src/app/models/task.interface';
import { TasksService } from 'src/app/services/tasks.service';

@Component({
  selector: 'app-tasks-left',
  templateUrl: './tasks-left.component.html',
  styleUrls: ['./tasks-left.component.scss']
})
export class TasksLeftComponent implements OnInit {
  tasks!: Task[];

  constructor(private taskSrv: TasksService) {}

async ngOnInit(): Promise<void> {
 const tasks = this.taskSrv.getTasks();
 this.tasks = tasks.filter(task => task.completed === false)
}

}