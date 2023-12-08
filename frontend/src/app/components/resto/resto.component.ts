import {Component, Input, OnInit} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {RestoDto} from "../../models/dto/resto.dto";
import {RestoDisplayComponent} from "./resto-display/resto-display.component";
import {AddRestoFormComponent} from "./add-resto-form/add-resto-form.component";
import { AddRestoFormData } from './add-resto-form/add-resto-form.dto';
import { RestoService } from '../../services/resto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-resto',
  standalone: true,
  imports: [CommonModule, NgOptimizedImage, RestoDisplayComponent, AddRestoFormComponent],
  templateUrl: './resto.component.html',
  styleUrl: './resto.component.css'
})
export class RestoComponent implements OnInit {

  public restos: RestoDto[] = [];

  constructor(private router: Router, private readonly restoService: RestoService) {
  }

  ngOnInit(): void {
    this.refreshRestos();
  }

  public refreshRestos() {
    this.restoService.loadRestos().subscribe(value => {
      this.restos = value;
      this.restos.forEach(resto => this.getPhoto(resto));
    })
  }

  // get image url
  public getPhoto(resto: RestoDto): void {
    this.restoService.getRestoPhoto(resto.id).subscribe(urlDto => {
      resto.photo = urlDto.url;
    });
  }

  public onRestoSubmitted(newRestoData: AddRestoFormData): void {
    this.restoService.addResto(newRestoData).subscribe(value => {
      this.restos.push(value);
      // link image to element
      this.getPhoto(value);
    })
  }

}
