import { Injectable } from '@angular/core';
import { MovieInterface } from '../models/movie-interface.interface';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class MoviesService {
  apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getMovies(){
    return this.http.get<MovieInterface[]>(`${this.apiUrl}movies-popular`);
  }

  getMovie(id: number){
    return this.http.get<MovieInterface>(`${this.apiUrl}movies-popular/${id}`)
  }
}
