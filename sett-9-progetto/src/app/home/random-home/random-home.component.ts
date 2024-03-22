import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-random-home',
  templateUrl: './random-home.component.html',
  styleUrls: ['./random-home.component.scss'],
})

export class RandomHomeComponent {
  cars: Car[] = [];
  evidenza: Car[] = [];
  included: number[] = [];
  marchio!: string;

  constructor() {
    this.getCars();
  }

  async getCars() {
    let response = await fetch('../../assets/db.json');
    let data = await response.json();
    this.cars = data;

    if (data) {
      this.printRandomCars();
      // this.getBrand();
    }
  }

  printRandomCars() {
    for (let i = 0; i < 2; i++) {
      let index = Math.floor(Math.random() * this.cars.length);
      if (this.included.includes(index)) {
        index = Math.floor(Math.random() * this.cars.length);
      } else {
        this.included.push(index);
      }
    }

    for (let i = 0; i < this.included.length; i++) {
      let carIndex = this.included[i] - 1;
      this.evidenza.push(this.cars[carIndex]);
    }
  }

  // getBrand() {
  //   for (let i = 0; i < this.evidenza.length; i++) {
  //     if (this.cars[i].brand === "Audi") {
  //       this.marchio = "/marchio1"
  //     } else if (this.cars[i].brand === "Fiat") {
  //       this.marchio = "/marchio2"
  //     } else if (this.cars[i].brand === "Ford") {
  //       this.marchio = "/marchio3"
  //     }
  //   }
  // }
}
