import { Component } from '@angular/core';
import { Car } from '../models/car.interface';

@Component({
  selector: 'app-marchio3',
  templateUrl: './marchio3.component.html',
  styleUrls: ['./marchio3.component.scss']
})
export class Marchio3Component {
  cars!: Car[];
  ford: Car[] = [];
  logo!: string;

  constructor() {
    this.getCars();
  }

  async getCars() {
    let response = await fetch('../assets/db.json');
    let data = await response.json();    
    this.cars = data;

    if(data) {
      this.getMarchio();
    }
  }

  getMarchio() {
    for (let i = 0; i < this.cars.length; i++) {
      if (this.cars[i].brand === "Ford") {
        this.ford.push(this.cars[i]);
      }
    }        
  } 
}
