import {Injectable} from '@angular/core';
import {YDto} from "../models/dto/y.dto";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UrlDto} from "../models/dto/url.dto";
import { AddYFormData } from '../components/y/add-y-form/add-y-form.dto';
// import {AddYFormData} from "../components/y/add-y-form/add-y-form.component";

@Injectable({
  providedIn: 'root'
})
export class YService {

  constructor(private httpClient: HttpClient) {
    this.loadYs();
  }

  public loadYs(): Observable<YDto[]> {
    return this.httpClient.get<YDto[]>(`http://localhost:8080/ys`)
  }

  public getYCover(id: number): Observable<UrlDto> {
    return this.httpClient.get<UrlDto>(`http://localhost:8080/ys/${id}/cover`);
  }

  public addY(newYData: AddYFormData): Observable<YDto> {
    return this.httpClient.post<YDto>(`http://localhost:8080/ys`, newYData);
  }
}
