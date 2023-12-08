import {Injectable} from '@angular/core';
import {RestoDto} from "../models/dto/resto.dto";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UrlDto} from "../models/dto/url.dto";
import { AddRestoFormData } from '../components/resto/add-resto-form/add-resto-form.dto';
// import {AddRestoFormData} from "../components/y/add-y-form/add-y-form.component";

@Injectable({
  providedIn: 'root'
})
export class RestoService {

  constructor(private httpClient: HttpClient) {
    this.loadRestos();
  }

  public loadRestos(): Observable<RestoDto[]> {
    return this.httpClient.get<RestoDto[]>(`http://localhost:8080/restaurants`)
  }

  public getRestoById(id: number): Observable<RestoDto> {
    return this.httpClient.get<RestoDto>(`http://localhost:8080/restaurants/${id}`)
  }

  public getRestoPhoto(id: number): Observable<UrlDto> {
    return this.httpClient.get<UrlDto>(`http://localhost:8080/restaurants/${id}/photo`);
  }

  // public setRestoPhoto(id: number): Observable<UrlDto> {
  //   return this.httpClient.put<UrlDto>(`http://localhost:8080/restaurants/${id}/photo`, );
  // }

  public addResto(newRestoData: AddRestoFormData): Observable<RestoDto> {
    return this.httpClient.post<RestoDto>(`http://localhost:8080/restaurant`, newRestoData);
  }
}
