import {Component, OnInit} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {YDto} from "../../models/dto/y.dto";
import {YDisplayComponent} from "./y-display/y-display.component";
import {AddYFormComponent} from "./add-y-form/add-y-form.component";
import { AddYFormData } from './add-y-form/add-y-form.dto';
import { YService } from '../../services/y.service';

@Component({
  selector: 'app-y',
  standalone: true,
  imports: [CommonModule, NgOptimizedImage, YDisplayComponent, AddYFormComponent],
  templateUrl: './y.component.html',
  styleUrl: './y.component.css'
})
export class YComponent implements OnInit {

  public ys: YDto[] = [];

  constructor(private readonly yService: YService) {
  }

  ngOnInit(): void {
    this.refreshYs();
  }

  public refreshYs() {
    this.yService.loadYs().subscribe(value => {
      this.ys = value;
      // refresh image
      // this.ys.forEach(y => this.getCover(y));
    })
  }

  // get image url
  // public getCover(y: YDto): void {
  //   this.yService.getYCover(y.id).subscribe(urlDto => {
  //     y.coverUrl = urlDto.url;
  //   });
  // }

  public onYSubmitted(newYData: AddYFormData): void {
    this.yService.addY(newYData).subscribe(value => {
      this.ys.push(value);
      // link image to element
      // this.getCover(value);
    })
  }

}
