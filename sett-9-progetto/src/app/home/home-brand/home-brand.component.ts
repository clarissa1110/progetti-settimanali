import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-home-brand',
  templateUrl: './home-brand.component.html',
  styleUrls: ['./home-brand.component.scss']
})
export class HomeBrandComponent {
  cars!: Car[];
  included: string[] = [];


  constructor() {
    this.getCarBrand();
  }

  async getCarBrand() {
    let response = await fetch('../../assets/db.json');
    let data = await response.json();
    this.cars = data;
    
    if (data) {
      this.noRepeat();
    }
  }

  noRepeat() {
    for (let i=0; i<3; i++) {
      let brand = this.cars[i].brand;
      
      if (this.included.includes(brand)) {
        return 
      } else {
        this.included.push(brand);
      }
    }
}
}
