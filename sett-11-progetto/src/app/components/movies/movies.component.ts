import { Component, OnInit } from '@angular/core';
import { MovieInterface } from 'src/app/models/movie-interface.interface';
import { MoviesService } from 'src/app/services/movies.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss'],
})
export class MoviesComponent implements OnInit {
  movies!: MovieInterface[];

  constructor(private movieSrv: MoviesService) {}

  ngOnInit(){
    this.movieSrv.getMovies().subscribe((data) => {
      this.movies = data;
    })
  }
}
