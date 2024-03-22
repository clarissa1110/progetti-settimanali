import { Component } from '@angular/core';
import { Car } from '../models/car.interface';

@Component({
  selector: 'app-marchio1',
  templateUrl: './marchio1.component.html',
  styleUrls: ['./marchio1.component.scss'],
})
export class Marchio1Component {
  cars!: Car[];
  audi: Car[] = [];
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
      if (this.cars[i].brand === "Audi") {
        this.audi.push(this.cars[i]);
      }
    }        
  }  
}
