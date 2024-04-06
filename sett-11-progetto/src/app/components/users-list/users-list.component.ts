import { Component, OnInit } from '@angular/core';
import { UsersInterface } from 'src/app/models/users-interface.interface';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss']
})
export class UsersListComponent implements OnInit{

  users!: UsersInterface[];

  constructor(private usersSrv: UsersService) {}

  ngOnInit() {
    this.usersSrv.getUsers().subscribe((data) => {
      this.users = data;
    })
  }

}
