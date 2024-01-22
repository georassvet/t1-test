# Getting Started

| Method | URL                             | Description                                                    |
|--------|---------------------------------|----------------------------------------------------------------|
| `GET`  | `/parse/{str}?sort=(desc\|asc)` | Count elements in a string {str} and sort it by value (desc\|asc) 

## Example
**Request**: [http://localhost:8080/parse/zzzzaaaaaaaaabbbqqqqrrrreeeeee?sort=desc]() <br>
**Response**: `{"a":9,"e":6,"q":4,"r":4,"z":4,"b":3}`