import { Component, Input, OnInit } from '@angular/core';
import { RestoDto } from '../../../models/dto/resto.dto';
import { NgOptimizedImage } from '@angular/common';

@Component({
  selector: 'app-resto-details-display',
  standalone: true,
  imports: [NgOptimizedImage],
  templateUrl: './resto-details-display.component.html',
  styleUrl: './resto-details-display.component.css'
})
export class RestoDetailsDisplayComponent{

  @Input() resto: RestoDto = {id:0,name:"",address:"",avgReview: 0, photo: "", tag: 0, reviews: []};

}
