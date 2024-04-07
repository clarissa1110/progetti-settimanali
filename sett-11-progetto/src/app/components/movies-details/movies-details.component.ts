import { Component, OnInit } from '@angular/core';
import { MovieInterface } from 'src/app/models/movie-interface.interface';
import { MoviesService } from 'src/app/services/movies.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movies-details',
  templateUrl: './movies-details.component.html',
  styleUrls: ['./movies-details.component.scss']
})
export class MoviesDetailsComponent implements OnInit{
   movie!: MovieInterface;

   constructor(private movieSrv: MoviesService, private router: ActivatedRoute) {}

   ngOnInit(): void {
     this.router.params.subscribe((params) => {
      const id = +params['id'];
      this.movieSrv.getMovie(id).subscribe((data) => {
        this.movie = data;
      })
     })
   }
}
