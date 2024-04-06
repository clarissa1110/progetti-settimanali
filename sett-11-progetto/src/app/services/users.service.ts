import { Injectable } from '@angular/core';
import { UsersInterface } from '../models/users-interface.interface';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  apiUrl = environment.apiUrl
  constructor(private http: HttpClient) { }

  getUsers(){
    return this.http.get<UsersInterface[]>(`${this.apiUrl}users`)
  }

  getUser(id: number){
    return this.http.get<UsersInterface>(`${this.apiUrl}users/${id}`)
  }
}
