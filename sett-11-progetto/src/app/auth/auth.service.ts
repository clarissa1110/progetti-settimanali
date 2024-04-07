import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Register } from '../models/register.interface';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiURL = environment.apiUrl;

  constructor(private http: HttpClient) { }

  signUp(data: Register){
    return this.http.post(`${this.apiURL}register`, data);
  }
}