import { Component } from '@angular/core';
import { Car } from '../models/car.interface';

@Component({
  selector: 'app-marchio2',
  templateUrl: './marchio2.component.html',
  styleUrls: ['./marchio2.component.scss']
})
export class Marchio2Component {
  cars!: Car[];
  fiat: Car[] = [];
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
      if (this.cars[i].brand === "Fiat") {
        this.fiat.push(this.cars[i]);
      }
    }        
  } 
}
