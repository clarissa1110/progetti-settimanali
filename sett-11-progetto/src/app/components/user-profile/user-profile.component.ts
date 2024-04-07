import { Component, OnInit } from '@angular/core';
import { UsersInterface } from 'src/app/models/users-interface.interface';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit{

  user!: UsersInterface;

  constructor(private usersSrv: UsersService) {}

  ngOnInit(): void {
    // this.usersSrv.getUser(id).subscribe((data) => {
    //   this.user = data;
    // })
  } //non trova l'id????????

}
