import { Injectable } from "@angular/core";
import { Income, Expense, Transaction } from "../Domains/app-interfaces";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { AppService } from "./auth-service";

@Injectable()
export class TransactionService {

    constructor(private http: HttpClient, private authService: AppService){}

    addIncome(income:Income){
        return this.http.post<Boolean>("http://localhost:8080/add/income", income, {headers: this.authService.getHeader()});
    }

    addExpense(expense: Expense) {
        return this.http.post<Boolean>("http://localhost:8080/add/expense", expense, {headers: this.authService.getHeader()});
    }

    getTransactionList(): Observable<Transaction[]> {
        return this.http.get<Transaction[]>("http://localhost:8080/list/all", {headers: this.authService.getHeader()});
    }

    delete(id: number){
        return this.http.get<Boolean>("http://localhost:8080/delete/trans/" + id, {headers: this.authService.getHeader()});
    }
}